package com.mbank.assess.controller;

import com.mbank.assess.constant.Constants;

final class ApiRequestMapping {

    private ApiRequestMapping() {
        // prevent instantiation
    }

    enum Public {
        ;
        static final String BASE_URI = "/public";
        
        static final String BASE_V1_ASSESSMENT_URI = Public.BASE_URI + "/v1/assessment";
        
        static final String LIST_ASSESSMENT_USER_URI = Public.BASE_V1_ASSESSMENT_URI + "/user/list";
        
        static final String INSERT_ASSESSMENT_USER_URI = Public.BASE_V1_ASSESSMENT_URI + "/user";
        
        static final String UPDATE_ASSESSMENT_USER_URI = Public.BASE_V1_ASSESSMENT_URI + "/user/{"+ Constants.PARAM_ID +"}";

        static final String LIST_ASSESSMENT_EXT_PARTY_URI = Public.BASE_V1_ASSESSMENT_URI + "/extparty";
    }

    enum Private {
    	;

        static final String BASE_URI = "/private";
    }

}
