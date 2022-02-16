package com.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Data
public class UdirCheckStatusResponse {
    @SerializedName("txn_status_details")
    private Map<String, Object> txnStatusDetails;
}
