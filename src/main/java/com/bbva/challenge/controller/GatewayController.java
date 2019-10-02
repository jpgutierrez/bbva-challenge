package com.bbva.challenge.controller;

import com.bbva.challenge.service.BaseService;
import com.bbva.challenge.service.GatewayService;
import com.bbva.challenge.service.NoSqlService;
import com.bbva.challenge.service.SqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Gateway")
@RestController
@RequestMapping(value = "/gateway")
public class GatewayController {

    @Autowired
    GatewayService gatewayService;

    @Autowired
    SqlService sqlService;

    @Autowired
    NoSqlService noSqlService;

    @ApiOperation(value = "Execute query")
    @GetMapping(value = "/execute")
    public ResponseEntity<Object> executeQuery(@RequestParam String query) {

        BaseService service = gatewayService.getService(query);
        Object response = service.execute(query);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Execute SQL query")
    @GetMapping(value = "/execute/sql")
    public ResponseEntity<Object> executeQuerySQL(@RequestParam String query) {
        Object response = sqlService.execute(query);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Execute noSQL query")
    @GetMapping(value = "/execute/nosql")
    public ResponseEntity<Object> executeQueryNoSQL(@RequestParam String query) {
        Object response = noSqlService.execute(query);
        return ResponseEntity.ok(response);
    }

}
