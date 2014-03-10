/*
 * Opennaru, Inc. http://www.opennaru.com/
 *  
 * Copyright 2014 Opennaru, Inc. and/or its affiliates.
 * All rights reserved by Opennaru, Inc.
 *  
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
package com.opennaru.khan.stuckthread.management;

import java.util.concurrent.atomic.AtomicLong;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

import com.opennaru.khan.stuckthread.StuckThreadDetectionValve;


public class StuckMonitorMBeanImpl extends StandardMBean implements
		StuckMonitorMBean {

	private StuckThreadDetectionValve valve;
		
	protected AtomicLong stuckThreadCount = new AtomicLong();
	protected AtomicLong hoggingThreadCount = new AtomicLong();

	
	/**
	 * SessionMBeanImpl
	 * 
	 * @throws NotCompliantMBeanException
	 */
	public StuckMonitorMBeanImpl(StuckThreadDetectionValve valve)
			throws NotCompliantMBeanException {
		super(StuckMonitorMBean.class);

		this.valve = valve;
	}

	public long getStuckThreadCount() {
		return valve.getStuckThreadCount();
	}

    public long[] stuckThreadIds() {
    	return valve.getStuckThreadIds();
    }

	public long getActiveThreadCount() {
		return valve.getActiveThreadCount();
	}    
	public long getHoggingThreadCount() {
		return valve.getHoggingThreadCount();
	}
	
	public int getStuckThreshold() {
		return valve.getStuckThreshold();
	}
	
	public int getHoggingThreshold() {
		return valve.getHoggingThreshold();
	}

}