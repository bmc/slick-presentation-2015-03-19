package db

import com.example.slickness.models._

import scala.slick.driver.JdbcProfile

/** Allows dynamic selection of database type.
  */
trait Profile {
  val profile: JdbcProfile
}

/** Base implementation of the data access layer.
  */
class DAL(override val profile: JdbcProfile)
  extends Profile
  with EmployeesComponent
  with PhonesComponent {

  import profile.simple._

  val ddl = Employees.ddl ++ Phones.ddl
}

trait EmployeesComponent {
  self: Profile =>

  import profile.simple._

  class EmployeesTable(tag: Tag) extends Table[Employee](tag, "employees") {
    def id        = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def firstName = column[String]("first_name")
    def lastName  = column[String]("last_name")
    def salary    = column[Int]("salary")

    def * = (id.?, firstName, lastName, salary) <>
            (Employee.tupled, Employee.unapply)
  }

  val Employees = TableQuery[EmployeesTable]
}

trait PhonesComponent {
  self: Profile with EmployeesComponent =>

  import profile.simple._

  class PhonesTable(tag: Tag) extends Table[PhoneNumber](tag, "phones") {
    def id         = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def employeeID = column[Int]("employee_id")
    def number     = column[String]("number")

    def * = (id.?, employeeID, number) <>
            (PhoneNumber.tupled, PhoneNumber.unapply)

    def employee = foreignKey("pn_fk_01", employeeID, Employees)(
      _.id,
      onUpdate=ForeignKeyAction.Restrict,
      onDelete=ForeignKeyAction.Cascade
    )
  }

  val Phones = TableQuery[PhonesTable]
}
