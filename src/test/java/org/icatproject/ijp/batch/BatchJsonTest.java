package org.icatproject.ijp.batch;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class BatchJsonTest {

	@Test
	public void testList() throws Exception {
		assertEquals("[\"a\",\"bb\",\"ccc\"]", BatchJson.list(Arrays.asList("a", "bb", "ccc")));
	}

	@Test
	public void testGetStatus() throws Exception {
		assertEquals("{\"status\":\"Unknown\"}", BatchJson.getStatus(JobStatus.Unknown));
	}

	@Test
	public void testSubmitRDP() throws Exception {
		assertEquals(
				"{\"rdp\":{\"username\":\"fred\",\"password\":\"secret\",\"host\":\"a.b.c\"}}",
				BatchJson.submitRDP("fred", "secret", "a.b.c"));
	}
}