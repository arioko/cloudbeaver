/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2024 DBeaver Corp and others
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
package io.cloudbeaver.server.events;

import io.cloudbeaver.model.WebServerMessage;
import io.cloudbeaver.model.session.BaseWebSession;
import org.jkiss.code.NotNull;
import org.jkiss.dbeaver.model.websocket.event.WSSessionLogUpdatedEvent;

public class WSLogEventHandler extends WSDefaultEventHandler<WSSessionLogUpdatedEvent> {

    protected void updateSessionData(@NotNull BaseWebSession activeUserSession, @NotNull WSSessionLogUpdatedEvent event) {
        activeUserSession.addSessionMessage(new WebServerMessage(event.getMessageType(), event.getMessage()));
    }

    protected boolean isAcceptableInSession(@NotNull BaseWebSession activeUserSession, @NotNull WSSessionLogUpdatedEvent event) {
        return WSWebUtils.isSessionIdEquals(activeUserSession, event.getSessionId());
    }
}
