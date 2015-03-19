package com.example.slickness

import _root_.db.DAL

import scala.slick.driver.SQLiteDriver
import models._

object Main {

  import SQLiteDriver.simple._

  private val DbUrl = "jdbc:sqlite:/tmp/my.db"
  private val Driver = "org.sqlite.JDBC"

  def main(args: Array[String]): Unit = {

    val db = Database.forURL(DbUrl, driver=Driver)
    val dal = new DAL(SQLiteDriver)

    args.toList match {
      case "create" :: Nil => createDatabase(dal, db)
      case "query" :: Nil  => runSomeQueries(dal, db)
      case _               => println("Usage: Main create|query")
    }
  }

  private def createDatabase(dal: DAL, db: Database): Unit = {
    import dal.profile.simple._
    import dal._

    db withSession { implicit session: Session =>
      dal.ddl.drop
      dal.ddl.create

      Employees ++= Seq( Employee(id = None, firstName = "Joe",
                                  lastName = "Smith", salary = 10000),
                         Employee(id = None, firstName = "Maria",
                                  lastName = "Sanchez", salary = 200000))
    }
  }

  private def runSomeQueries(dal: DAL, db: Database): Unit = {
    import dal.profile.simple._
    import dal._

    val q = for { e <- Employees if e.firstName === "Joe" } yield e

    db withSession { implicit session =>
      println(q.selectStatement)
      val employees = q.list
      employees.foreach { e =>
        println(e)
      }

      val e = employees.headOption
      e.map { emp =>
        Phones ++= Seq( PhoneNumber(id = None, employeeID = emp.id.get, "867-5309"),
                        PhoneNumber(id = None, employeeID = emp.id.get, "555-1212") )

        Phones.filter(_.employeeID === emp.id).foreach {p =>
          println(p)
        }
      }
    }
  }
}
