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
package net.lr.tutorial.karaf.db.command;

import net.lr.tutorial.karaf.db.service.DbAccess;

import org.apache.felix.service.command.CommandSession;
import org.apache.karaf.shell.commands.Action;
import org.apache.karaf.shell.commands.Command;

@Command(scope = "db", name = "tables", description = "Shows all tables in this db")
public class ShowTablesCommand implements Action
{
	private DbAccess	dbAccess;

	public void setDbAccess(final DbAccess dbAccess)
	{
		this.dbAccess = dbAccess;
	}

	@Override
	public Object execute(final CommandSession session) throws Exception
	{
		final ShellTable table = dbAccess.getTableInfo();
		table.print();
		return null;
	}

}
