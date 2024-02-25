package com.loadbalancer.config;

import com.loadbalancer.constant.LoadBalancingAlgorithm;

class AlgorithmConfig {
    private LoadBalancingAlgorithm algorithm;
    private boolean enabled;

    // Getters and setters
    public LoadBalancingAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(LoadBalancingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

