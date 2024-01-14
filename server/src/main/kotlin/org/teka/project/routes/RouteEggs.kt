package org.teka.project.routes


import org.teka.project.data.remote.dto.egg_collection.CreateEggCollectionDto
import com.example.data.remote.dto.egg_collection.EggCollectionDTO
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.teka.project.domain.repository.EggCollectionRepository
import org.teka.project.util.GenericResponse

fun Route.eggsRoute() {

    val eggCollectionRepository = EggCollectionRepository()


    route("/api/eggs"){


        get("/test"){
            call.respondText("Hello World Person Test!")
        }

        post("/create") {
            val eggCollectionDto: CreateEggCollectionDto = call.receive()

            val savedEggCollection = eggCollectionRepository.create(eggCollectionDto)


            if (savedEggCollection != null){
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(
                        isSuccess = true,
                        data = "collection saved"
                    )
                )

            }else{
                call.respond(
                    HttpStatusCode.BadRequest,
                    GenericResponse(
                        isSuccess = false,
                        data = "Error in registering user"
                    )
                )
            }
        }


        get("/all") {
            val eggCollectionList: List<EggCollectionDTO> = eggCollectionRepository.findAll()

            if (eggCollectionList != null){
                call.respond(
                    HttpStatusCode.OK,
                    GenericResponse(
                        isSuccess = true,
                        data =  eggCollectionList
                    )
                )

            }else{
                call.respond(
                    HttpStatusCode.BadRequest,
                    GenericResponse(
                        isSuccess = false,
                        data = "Error in retrieving users"
                    )
                )
            }
        }


        get("/{id}") {
            val found = call.parameters["id"]?.let { uuid -> eggCollectionRepository.find(uuid) }
            found?.let { call.respond(it) } ?: call.respond(HttpStatusCode.NotFound)
        }
        delete("/{id}") {
            call.parameters["id"]?.let { it1 -> eggCollectionRepository.delete(it1) }?.let { it2 -> call.respond(it2) }
        }
        put("/{id}") {
            call.parameters["id"]?.let { it1 ->
                eggCollectionRepository.update(
                    it1,
                    call.receive()
                )
            }?.let { it2 ->
                call.respond(it2)
            }
        }


    }
}