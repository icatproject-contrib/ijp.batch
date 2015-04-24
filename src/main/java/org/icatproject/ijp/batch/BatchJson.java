package org.icatproject.ijp.batch;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.icatproject.ijp.batch.exceptions.BatchException;

public class BatchJson {

	private static Logger logger = Logger.getLogger(BatchJson.class);

	public static String getStatus(JobStatus status) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Json.createGenerator(baos).writeStartObject().write("status", status.name()).writeEnd().close();
		return baos.toString();
	}

	public static String list(List<String> jobs) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JsonGenerator gen = Json.createGenerator(baos).writeStartArray();
		for (String jobId : jobs) {
			gen.write(jobId);
		}
		gen.writeEnd().close();
		return baos.toString();
	}

	public static Response batchExceptionError(BatchException e) {
		logger.info("Processing: " + e.getClass() + " " + e.getMessage());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JsonGenerator gen = Json.createGenerator(baos);
		gen.writeStartObject().write("code", e.getClass().getSimpleName()).write("message", e.getMessage());
		gen.writeEnd().close();
		return Response.status(e.getHttpStatusCode()).entity(baos.toString()).build();
	}

	public static Response batchExceptionError(WebApplicationException e) {
		logger.info("Processing: " + e.getClass() + " " + e.getMessage());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JsonGenerator gen = Json.createGenerator(baos);
		gen.writeStartObject().write("code", "InternalException").write("message", e.getClass() + " " + e.getMessage())
				.writeEnd().close();
		return Response.status(HttpURLConnection.HTTP_INTERNAL_ERROR).entity(baos.toString()).build();
	}

	public static String submitBatch(String jobId) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Json.createGenerator(baos).writeStartObject().write("jobId", jobId).writeEnd().close();
		return baos.toString();
	}

	public static String submitRDP(String username, String password, String host) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JsonGenerator gen = Json.createGenerator(baos);
		gen.writeStartObject().writeStartObject("rdp").write("username", username).write("password", password)
				.write("host", host).writeEnd().writeEnd().close();
		return baos.toString();
	}

	public static String estimate(int time) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JsonGenerator gen = Json.createGenerator(baos);
		gen.writeStartObject().write("time", time).writeEnd().close();
		return baos.toString();
	}

}
