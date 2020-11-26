package client.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import client.dominio.EvaluacionesDTO;
import client.util.ResponseDTO;

@FeignClient(url="http://192.168.1.33:8090", name="evaluaciones")
public interface ClienteEvaluaciones {

	@GetMapping(path="/evaluaciones", produces="application/json")
	ResponseDTO listar();
	
	@PostMapping(path="/evaluaciones",produces="application/json")
	ResponseDTO crear(@RequestBody EvaluacionesDTO evaluaciones);
	
	@PutMapping(path="/evaluaciones",produces="application/json")
	ResponseDTO actualizar(@RequestBody EvaluacionesDTO evaluaciones);
	
	@DeleteMapping(path="/evaluaciones/{id}",produces="application/json")
	ResponseDTO borrar(@RequestParam Long id);
}
