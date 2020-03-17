package com.psl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.psl.model.Address;
import com.psl.model.Employee;
import com.psl.service.JsonService;

@SpringBootApplication
public class GsonApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException, JSONException {
		SpringApplication.run(GsonApplication.class, args);
		JsonService jsonService = new JsonService();
		Employee e = new Employee();
		e.setId(1);
		List<String> mobileNumber = new ArrayList<>();
		mobileNumber.add("9933878542");
		mobileNumber.add("9934289605");
		e.setMobileNumber(mobileNumber);
		e.setName("dfhysrt");
		e.setAddress(new Address("125", "Maha", "12345"));
		JSONObject jsonObject = jsonService.ObjecttoJSONObject(e);
		JSONArray mobileJson = jsonObject.getJSONArray("mobileNumber");
		JSONObject newJson = jsonObject.getJSONObject("address");
//		System.out.println(jsonObject.getJSONObject("address").ge
		System.out.println(jsonService.exampleJSONObject());
		jsonService.exampleJSONML();
		jsonService.exampeJSONStringer();
//		System.out.println(jsonObject);
//		System.out.println(new JSONObject(e));
//		JSONObject o=new JSONObject(e);
//		for(Object a:mobileJson)
//		{
//			System.out.println(a.toString());
//		}
//	
//		System.out.println(jsonObject);
//
//		System.out.println(jsonService.JSONObjecttoObject(new JSONObject("{\"address\":{\"city\":\"125\",\"state\":\"Maha\"},\"mobileNumber\":[\"9933878542\",\"9934289605\"],\"id\":\"1\"}")));
//	}

	}
}
