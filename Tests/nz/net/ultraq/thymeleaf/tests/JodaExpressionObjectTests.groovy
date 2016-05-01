/* 
 * Copyright 2016, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.thymeleaf.tests

import nz.net.ultraq.thymeleaf.JodaExpressionObject

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*

/**
 * Tests for the {@link JodaExpressionObject} class.
 * 
 * @author Emanuel Rabina
 */
class JodaExpressionObjectTests {

	private JodaExpressionObject joda

	/**
	 * Set up the Joda expression object.
	 */
	@Before
	void setup() {

		joda = new JodaExpressionObject()
	}

	/**
	 * Test that the date formatter is just the Joda one under the hood.
	 */
	@Test
	void formatDate() {

		def date = new DateTime()
		def pattern = 'yyyy-MM-dd'
		def result = joda.format(date, pattern)

		assertEquals(DateTimeFormat.forPattern(pattern).print(date), result)
	}

	/**
	 * Test that, when given a <tt>null</tt> date, then <tt>null</tt> is returned.
	 */
	@Test
	void formatDateNull() {

		assertNull(joda.format(null, 'yyyy-MM-dd'))
	}
}
