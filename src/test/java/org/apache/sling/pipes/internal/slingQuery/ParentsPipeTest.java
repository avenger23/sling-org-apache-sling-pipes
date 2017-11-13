/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.pipes.internal.slingQuery;

import org.apache.sling.pipes.AbstractPipeTest;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParentsPipeTest extends AbstractPipeTest {

    @Test
    public void testParents() throws Exception {
        Collection<String> outputs = plumber.newPipe(context.resourceResolver())
                .echo(SAME_COLOR)
                .parents("[color=green]").run().getCurrentPathSet();
        assertEquals("there should be 2 outputs", 2, outputs.size());
        assertTrue("there should be apple", outputs.contains(PATH_APPLE));
        assertTrue("there should be pea", outputs.contains(PATH_PEA));
    }
}