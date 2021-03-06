/*
 * Copyright (C) Actility, SA. All Rights Reserved.
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
 */

#ifndef _STRUCT_H_
#define _STRUCT_H_

typedef struct _cov
{
  int cz_index;
  unsigned int cz_cluster;
  unsigned int cz_attribut;
  int cz_mint;
  int cz_maxt;
  char *cz_mincov;
  int cz_sz;
  char *cz_data; // watteco binary buffer ready to send
  int cz_error;
  unsigned int cz_used;
} t_cov;

int CovGetMinIntervalForAttr(int attr);

#endif /* _STRUCT_H_ */
