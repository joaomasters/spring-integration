/*
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.sftp.session;

import org.springframework.integration.file.remote.ClientCallback;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.file.remote.session.SessionFactory;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;

/**
 * SFTP version of {@code RemoteFileTemplate} providing type-safe access to
 * the underlying ChannelSftp object.
 *
 * @author Gary Russell
 * @since 4.1
 *
 */
public class SftpRemoteFileTemplate extends RemoteFileTemplate<LsEntry> {

	public SftpRemoteFileTemplate(SessionFactory<LsEntry> sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, C> T executeWithClient(final ClientCallback<C, T> callback) {
		return doExecuteWithClient((ClientCallback<ChannelSftp, T>) callback);
	}

	protected <T> T doExecuteWithClient(final ClientCallback<ChannelSftp, T> callback) {
		return execute(session -> callback.doWithClient((ChannelSftp) session.getClientInstance()));
	}

}
