package com.psl.service;

import org.json.JSONArray;
import org.json.JSONML;
import org.json.JSONObject;
import org.json.JSONStringer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psl.model.Employee;

public class JsonService {
	public JSONObject stringtoJSONObject(String inputString) {

		return new JSONObject(inputString);

	}

	public JSONObject ObjecttoJSONObject(Object object) {
		return new JSONObject(object);

	}

	public Employee JSONObjecttoObject(JSONObject jsonObject) throws JsonMappingException, JsonProcessingException {
		ObjectMapper m = new ObjectMapper();
		Employee e = m.readValue(jsonObject.toString(), Employee.class);
		return e;

	}

	public JSONObject exampleJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "chunchun");
		jsonObject.put("id", 2);
		String array[] = { "123456789", "1225478963" };
		jsonObject.put("mobileNumbers", new JSONArray(array));
		jsonObject.put("parentsName", JSONObject.NULL);
		jsonObject.put("isStudent", true);
		jsonObject.put("address", new JSONObject().put("city", "Pune").put("state", "Maha"));
		return jsonObject;

	}

	public JSONArray exampleJSONArray() {
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(true);
		jsonArray.put("Chunchun");
		jsonArray.put(1);
		jsonArray.put(new JSONObject().put("shdj", "dfhgt"));
		jsonArray.put(JSONObject.NULL);
		jsonArray.put(new JSONArray().put("sdfd").put(2));
		return jsonArray;

	}

	public JSONML exampleJSONML() {
		JSONArray list = new JSONArray();
		list.put("name");
		list.put("Robert");

		System.out.println("XML from a JSONArray: ");
		String xml = JSONML.toString(list);
		System.out.println(xml);

		System.out.println("JSONArray from a XML: ");
		list = JSONML.toJSONArray(xml);
		System.out.println(list);

		System.out.println("JSONObject from a XML: ");
		JSONObject object = JSONML.toJSONObject(xml);
		System.out.println(object);

		System.out.println("XML from a JSONObject: ");
		xml = JSONML.toString(object);
		System.out.println(xml);
		return null;

	}

	public void exampeJSONStringer() {
		String jsonText = new JSONStringer().object().key("Name").value("Robert").endObject().toString();
		System.out.println(jsonText);

		jsonText = new JSONStringer().array().value("Robert").value("Julia").value("Dan").endArray().toString();
		System.out.println(jsonText);

		jsonText = new JSONStringer().array().value("Robert").value("Julia").value("Dan").object().key("Name")
				.value("Robert").endObject().endArray().toString();
		System.out.println(jsonText);
	}

}
