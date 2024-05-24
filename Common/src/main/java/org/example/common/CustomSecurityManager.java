package org.example.common;

import java.security.Permission;

// Modify options で Add VM options を追加する
// -Djava.security.manager=org.example.common.CustomSecurityManager -Djava.security.policy=policy
public class CustomSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
    }
}
