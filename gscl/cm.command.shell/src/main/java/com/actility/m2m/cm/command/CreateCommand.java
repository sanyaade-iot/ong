/*
 * Copyright   Actility, SA. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License version
 * 2 only, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License version 2 for more details (a copy is
 * included at /legal/license.txt).
 *
 * You should have received a copy of the GNU General Public License
 * version 2 along with this work; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA
 *
 * Please contact Actility, SA.,  4, rue Ampere 22300 LANNION FRANCE
 * or visit www.actility.com if you need additional
 * information or have any questions.
 *
 * id $Id: CreateCommand.java 7124 2014-01-04 13:15:00Z JReich $
 * author $Author: JReich $
 * version $Revision: 7124 $
 * lastrevision $Date: 2014-01-04 14:15:00 +0100 (Sat, 04 Jan 2014) $
 * modifiedby $LastChangedBy: JReich $
 * lastmodified $LastChangedDate: 2014-01-04 14:15:00 +0100 (Sat, 04 Jan 2014) $
 */

package com.actility.m2m.cm.command;

import java.io.PrintStream;
import java.util.StringTokenizer;

import org.apache.felix.shell.Session;
import org.apache.felix.shell.SessionCommand;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

public class CreateCommand implements SessionCommand {
    private BundleContext bundleContext;

    public CreateCommand(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public String getName() {
        return "cm-create";
    }

    public String getUsage() {
        return "cm-create [-f] <pid>\n" + "-f     If specified the pid argument is a factory pid.\n"
                + "<pid>  Pid or factory pid of configuration to create\n" + "       depending on if -f flag is specified.";
    }

    public String getShortDescription() {
        return "Create a configuration and open it for editing.";
    }

    public void execute(String line, PrintStream out, PrintStream err) {
        // Ignore
    }

    public void execute(Session session, String line, PrintStream out, PrintStream err) {
        // Parse command line.
        StringTokenizer st = new StringTokenizer(line, " ");

        // Ignore the command name.
        st.nextToken();

        // Check for optional argument.
        String pid = null;
        boolean createFactoryConfiguration = false;
        if (st.countTokens() >= 1) {
            while (st.hasMoreTokens()) {
                String token = st.nextToken().trim();
                if (token.equals("-f")) {
                    createFactoryConfiguration = true;
                } else {
                    pid = token;
                }
            }
        }

        ServiceReference sr = bundleContext.getServiceReference(ConfigurationAdmin.class.getName());
        if (sr == null) {
            err.println("Unable to get the ConfigurationAdmin");
            return;
        }
        ConfigurationAdmin configAdmin = (ConfigurationAdmin) bundleContext.getService(sr);
        if (configAdmin == null) {
            err.println("Unable to get the ConfigurationAdmin");
            return;
        }

        session.setAttribute(Activator.CURRENT, null);
        session.setAttribute(Activator.EDITED, null);
        try {
            Configuration cfg = null;
            if (createFactoryConfiguration) {
                cfg = configAdmin.createFactoryConfiguration(pid, null);
            } else {
                cfg = configAdmin.getConfiguration(pid, null);
            }

            if (cfg == null) {
                throw new Exception("Failed creating configuration for " + pid);
            }
            session.setAttribute(Activator.CURRENT, cfg);
        } catch (Exception e) {
            out.println("Create failed. Details:");
            String reason = e.getMessage();
            out.println(reason == null ? "<unknown>: " + e.toString() : reason);
        } finally {
            bundleContext.ungetService(sr);
        }
    }
}
