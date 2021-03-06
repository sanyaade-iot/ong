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
 * id $Id: $
 * author $Author: $
 * version $Revision: $
 * lastrevision $Date: $
 * modifiedby $LastChangedBy: $
 * lastmodified $LastChangedDate: $
 */

package com.actility.m2m.servlet.song.http.stats;

import java.util.Date;

import com.actility.m2m.song.binding.http.LongPollingClientStats;

public final class LongPollingClientStatsImpl implements LongPollingClientStats {
    private final Date lastContactRequest;
    private final long nbOfContactRequests;
    private final long accOfContactRequests;
    private final long accOfNormalEndContactRequests;
    private final long accOfBadRequestEndContactRequests;
    private final long accOfErrorEndContactRequests;
    private final Date lastContactResponse;
    private final long accOfContactResponses;
    private final long accOfErrorEndContactResponses;
    private final Date lastLongPollingRequest;
    private final long nbOfLongPollingRequests;
    private final long accOfLongPollingRequests;
    private final long accOfContactEndLongPollingRequests;
    private final long accOfEmptyEndLongPollingRequests;
    private final long accOfErrorEndLongPollingRequests;
    private final long accOfExceptionEndLongPollingRequests;
    private final long accOfExpiredEndLongPollingRequests;
    private final String state;

    public LongPollingClientStatsImpl(Date lastContactRequest, long nbOfContactRequests, long accOfContactRequests,
            long accOfNormalEndContactRequests, long accOfBadRequestEndContactRequests, long accOfErrorEndContactRequests,
            Date lastContactResponse, long accOfContactResponses, long accOfErrorEndContactResponses,
            Date lastLongPollingRequest, long nbOfLongPollingRequests, long accOfLongPollingRequests,
            long accOfContactEndLongPollingRequests, long accOfEmptyEndLongPollingRequests,
            long accOfErrorEndLongPollingRequests, long accOfExceptionEndLongPollingRequests,
            long accOfExpiredEndLongPollingRequests, String state) {
        this.lastContactRequest = lastContactRequest;
        this.nbOfContactRequests = nbOfContactRequests;
        this.accOfContactRequests = accOfContactRequests;
        this.accOfNormalEndContactRequests = accOfNormalEndContactRequests;
        this.accOfBadRequestEndContactRequests = accOfBadRequestEndContactRequests;
        this.accOfErrorEndContactRequests = accOfErrorEndContactRequests;
        this.lastContactResponse = lastContactResponse;
        this.accOfContactResponses = accOfContactResponses;
        this.accOfErrorEndContactResponses = accOfErrorEndContactResponses;
        this.lastLongPollingRequest = lastLongPollingRequest;
        this.nbOfLongPollingRequests = nbOfLongPollingRequests;
        this.accOfLongPollingRequests = accOfLongPollingRequests;
        this.accOfContactEndLongPollingRequests = accOfContactEndLongPollingRequests;
        this.accOfEmptyEndLongPollingRequests = accOfEmptyEndLongPollingRequests;
        this.accOfErrorEndLongPollingRequests = accOfErrorEndLongPollingRequests;
        this.accOfExceptionEndLongPollingRequests = accOfExceptionEndLongPollingRequests;
        this.accOfExpiredEndLongPollingRequests = accOfExpiredEndLongPollingRequests;
        this.state = state;
    }

    public Date getLastContactRequest() {
        return lastContactRequest;
    }

    public long getNbOfContactRequests() {
        return nbOfContactRequests;
    }

    public long getAccOfContactRequests() {
        return accOfContactRequests;
    }

    public long getAccOfNormalEndContactRequests() {
        return accOfNormalEndContactRequests;
    }

    public long getAccOfBadRequestEndContactRequests() {
        return accOfBadRequestEndContactRequests;
    }

    public long getAccOfErrorEndContactRequests() {
        return accOfErrorEndContactRequests;
    }

    public Date getLastContactResponse() {
        return lastContactResponse;
    }

    public long getAccOfContactResponses() {
        return accOfContactResponses;
    }

    public long getAccOfErrorEndContactResponses() {
        return accOfErrorEndContactResponses;
    }

    public Date getLastLongPollingRequest() {
        return lastLongPollingRequest;
    }

    public long getNbOfLongPollingRequests() {
        return nbOfLongPollingRequests;
    }

    public long getAccOfLongPollingRequests() {
        return accOfLongPollingRequests;
    }

    public long getAccOfContactEndLongPollingRequests() {
        return accOfContactEndLongPollingRequests;
    }

    public long getAccOfEmptyEndLongPollingRequests() {
        return accOfEmptyEndLongPollingRequests;
    }

    public long getAccOfErrorEndLongPollingRequests() {
        return accOfErrorEndLongPollingRequests;
    }

    public long getAccOfExceptionEndLongPollingRequests() {
        return accOfExceptionEndLongPollingRequests;
    }

    public long getAccOfExpiredEndLongPollingRequests() {
        return accOfExpiredEndLongPollingRequests;
    }

    public String getStateMessage() {
        return state;
    }
}
