package com.example.slickness.models

case class Employee(id:        Option[Int],
                    firstName: String,
                    lastName:  String,
                    salary:    Int)

case class PhoneNumber(id:         Option[Int],
                       employeeID: Int,
                       number:     String)

