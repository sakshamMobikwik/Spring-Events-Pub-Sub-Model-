package com.example.controllers;

import com.example.model.Dummy;
import com.example.model.Employee;
import com.example.service.EmployeeSubscriber;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class DemoController {

    private static final Logger logger = LogManager.getLogger(DemoController.class);

    @Autowired
    private EmployeeSubscriber employeeSubscriber;

    public static String getMD5Hash(String[] inputs) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // Should never happen...
            throw new RuntimeException(e);
        }
        for (String input : inputs) {
            md.update(input.getBytes());
        }
        byte[] res = md.digest();
        byte[] b64 = Base64.encodeBase64(res);
        return new String(b64);
    }

    @GetMapping("/getMap")
    public HashMap<Integer,String> getMap() {
        String purple = "\u001B[45m";
        String reset = "\u001B[0m";
        logger.error( purple+" Error in Get Map "+reset);
        HashMap<Integer,String>  map = new HashMap<>();
        map.put(101,"Mobikwik");
        map.put(102,"Unicorn");
        return map;
    }

    @PostMapping("/postData")
    public void postData() {
       logger.info("Post Data Comes");
        List<String> list = new ArrayList<>();
        for(int i =0;i < 10;i++) {
            list.add("Item "+i);
        }
        for(String i : list) {
            System.out.println(i);
        }
    }
    @PostMapping("/getEmployee")
    public Employee getEmployee(@RequestBody Employee employee) {
        LinkedHashMap<String ,Object> linkedHashMap= (LinkedHashMap<String ,Object>) employee.getDetails();
        System.out.println(linkedHashMap.get("accountNumber"));
        System.out.println(linkedHashMap.get("ifsc"));
        System.out.println(linkedHashMap.get("receiverName"));
        List<String> list = Arrays.asList("A","B","C","D");
//        list.add("A");
//        list.add("B");
//        list.add("C");

        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String str = iter.next();
            if( str.equals("B")){
                iter.remove();
            }
        }
        System.out.println(list.toString());
        return employee;
    }

    @GetMapping("/aaa")
    public Dummy vulnScanner() {
        Dummy dummy = new Dummy();
        HashMap<String ,Object> map = new HashMap<>();
        map.put("a",101);
        map.put("b","Saksham");
        map.put("c",100.0);
        dummy.setDesiredInfo(map);
        return dummy;
    }
    @GetMapping("/bbb")
    public void bbb(@RequestParam(value = "isEnable",required = false) boolean isEnable) throws Exception {
    }
    @PostMapping("/abcx")
    public void fileExample(@RequestParam(value = "file") String multipartFile) {
        System.out.println(multipartFile);
    }
}
