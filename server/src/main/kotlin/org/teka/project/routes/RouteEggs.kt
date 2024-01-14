package org.teka.project.routes


import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.eggsRoute() {




    route("/api/eggs"){


        get("/test"){
            call.respondText("Hello World Person Test!")
        }

        post("/create") {
//            val personDto: CreatePersonDto = call.receive()
//
//            val savedUser = personRepository.create(personDto)
//
//
//            if (savedUser != null){
//                call.respond(
//                    HttpStatusCode.OK,
//                    GenericResponse(
//                        isSuccess = true,
//                        data = "user saved"
//                    )
//                )
//
//            }else{
//                call.respond(
//                    HttpStatusCode.BadRequest,
//                    GenericResponse(
//                        isSuccess = false,
//                        data = "Error in registering user"
//                    )
//                )
//            }
        }


        get("/all") {
//            val personList: List<FoundPersonWithAddressDto> = personRepository.findAll()
//
//            if (personList != null){
//                call.respond(
//                    HttpStatusCode.OK,
//                    GenericResponse(
//                        isSuccess = true,
//                        data =  personList
//                    )
//                )
//
//            }else{
//                call.respond(
//                    HttpStatusCode.BadRequest,
//                    GenericResponse(
//                        isSuccess = false,
//                        data = "Error in retrieving users"
//                    )
//                )
//            }
        }


        get("/{id}") {
//            val found = personRepository.find(call.parameters["id"]?.toInt()!!)
//            found?.let { call.respond(it) } ?: call.respond(HttpStatusCode.NotFound)
        }
        delete("/{id}") {
//            call.respond(personRepository.delete(call.parameters["id"]?.toInt()!!))
        }
        put("/{id}") {
//            call.respond(personRepository.update(call.parameters["id"]?.toInt()!!, call.receive()))
        }


    }
}