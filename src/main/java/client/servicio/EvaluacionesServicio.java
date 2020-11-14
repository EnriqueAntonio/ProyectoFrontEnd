package client.servicio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import client.cliente.ClienteEvaluaciones;
import client.dominio.EvaluacionesDTO;
import client.util.ResponseDTO;

@Service
public class EvaluacionesServicio {
	
	@Autowired
	ClienteEvaluaciones clientebd;
	
	public Map<String, Object>listar(){
		Map<String, Object>model= new HashMap<>();
		
		try
		{
			ResponseDTO evaluacionesList=clientebd.listar();
			model.put("evaluacionesList",evaluacionesList.getRespuesta());
		}
		catch(Exception e)
		{
			model.put("error", "error");
			model.put("msg", "Error al extraer los datos, si su problema persiste por favor contactenos");
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	public Map<String, Object>crear(EvaluacionesDTO evaluaciones){
		Map<String, Object>model= new HashMap<>();
		
		try {
			evaluaciones.setAprobado("A");
			evaluaciones.setEstado("1");
			ResponseDTO res=clientebd.crear(evaluaciones);
			
		} catch (HttpStatusCodeException  e) {
			
			model.put("msg", ResponseDTO.MSG_FATAL_ERROR);
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	public Map<String, Object>actualizar(EvaluacionesDTO evaluaciones){
		Map<String, Object>model= new HashMap<>();
		
		try {
			ResponseDTO res=clientebd.actualizar(evaluaciones);
			
		} catch (HttpStatusCodeException e) {
			
			model.put("msg", ResponseDTO.MSG_FATAL_ERROR);
			e.printStackTrace();
		}
		
		return model;
	}
	
	public  Map<String, Object>borrar(Long id){
		Map<String, Object>model= new HashMap<>();
		
		try {
			clientebd.borrar(id);
			
		} catch (HttpStatusCodeException e) {
			model.put("msg", ResponseDTO.MSG_FATAL_ERROR);
			e.printStackTrace();
		}
		return model;
	}
}
