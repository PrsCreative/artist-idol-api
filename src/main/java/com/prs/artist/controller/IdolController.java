package com.prs.artist.controller;

import com.prs.artist.bean.idol.IdolSearchReqMsg;
import com.prs.artist.bean.idol.IdolSearchRespMsg;
import com.prs.artist.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestScope
@RequiredArgsConstructor
public class IdolController
{
    private static final Logger logger = LoggerFactory.getLogger(IdolController.class);
    private static final String SERVICE_NAME = "getIdolInfo";
    private final AbstractService abstractService;

    @PostMapping(path = "/idol/getinfo", consumes = "application/json", produces = "application/json")
    public IdolSearchRespMsg getIdoInfo(@RequestBody IdolSearchReqMsg idolSearchReqMsg, HttpServletRequest request)
    {
        if (logger.isDebugEnabled()){
            logger.debug("Start {}", SERVICE_NAME);
        }
        return (IdolSearchRespMsg) abstractService.execute(idolSearchReqMsg, request, SERVICE_NAME);
    }

}