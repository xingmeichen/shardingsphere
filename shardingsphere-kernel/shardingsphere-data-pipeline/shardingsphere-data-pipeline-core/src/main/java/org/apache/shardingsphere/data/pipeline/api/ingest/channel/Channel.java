/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.data.pipeline.api.ingest.channel;

import org.apache.shardingsphere.data.pipeline.api.ingest.record.Record;

import java.util.List;

/**
 * Channel.
 */
public interface Channel {
    
    /**
     * push a {@code DataRecord} to channel.
     *
     * @param dataRecord data
     * @throws InterruptedException if thread interrupted
     */
    void pushRecord(Record dataRecord) throws InterruptedException;
    
    /**
     * fetch {@code Record} from channel, if the timeout also returns the record.
     *
     * @param batchSize record batch size
     * @param timeout timeout(seconds)
     * @return record
     */
    List<Record> fetchRecords(int batchSize, int timeout);
    
    /**
     * Ack the last batch.
     */
    void ack();
    
    /**
     * Close channel.
     */
    void close();
}
