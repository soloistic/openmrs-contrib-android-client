/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.mobile.utilities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.openmrs.mobile.models.retrofit.Form;

import java.lang.reflect.Modifier;

public class FormService {

    public static Form getForm(String valuereference)
    {
        valuereference=StringUtils.unescapeJavaString(valuereference);

        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        return gson.fromJson(valuereference,Form.class);
    }

}
