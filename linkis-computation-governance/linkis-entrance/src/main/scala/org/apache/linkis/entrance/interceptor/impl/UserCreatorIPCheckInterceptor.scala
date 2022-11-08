/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.linkis.entrance.interceptor.impl

import org.apache.linkis.entrance.conf.EntranceConfiguration
import org.apache.linkis.entrance.interceptor.EntranceInterceptor
import org.apache.linkis.governance.common.entity.job.JobRequest

import java.lang

class UserCreatorIPCheckInterceptor extends EntranceInterceptor {

  /**
   * The apply function supplements the information of the incoming parameter task, making the
   * content of the task more complete. Additional information includes Function is a supplement to
   * the information of the passed in parameter task, making the content of this task more complete.
   * Additional information includes: user IP address restrictions
   */
  override def apply(jobRequest: JobRequest, logAppender: lang.StringBuilder): JobRequest = {
    if (EntranceConfiguration.CREATOR_IP_SWITCH.getHotValue()) {
      UserCreatorIPCheckUtils.checkUserIp(jobRequest, logAppender)
    } else {
      jobRequest
    }
  }

}
