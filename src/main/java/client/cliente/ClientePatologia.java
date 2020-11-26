package client.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import client.dominio.PatologiaDTO;
import client.util.ResponseDTO;

@FeignClient(url="http://192.168.1.33:8090", name="patologia")
public interface ClientePatologia {
	
	@GetMapping(path="/patologia", produces="application/json")
	ResponseDTO listar();
	
	@GetMapping(path="/patologia/{id}", produces="application/json")
	ResponseDTO buscar(@RequestParam Long id);
	
	@PostMapping(path="/patologia",produces="application/json")
	ResponseDTO crear(@RequestBody PatologiaDTO patologia);
	
	@PutMapping(path="/patologia",produces="application/json")
	ResponseDTO actualizar(@RequestBody PatologiaDTO patologia);
	
	@DeleteMapping(path="/patologia/{id}", produces="application/json")
	ResponseDTO borrar(@RequestParam Long id);

}
