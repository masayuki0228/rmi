package org.example.client;

import org.example.common.Condition;

public class ConditionImpl implements Condition {
    @Override
    public String getOS() {
        return "mac";
    }
}
