package com.loadbalancer.service;

import com.loadbalancer.algorithms.LeastConnectionsLoadBalancer;
import com.loadbalancer.algorithms.LoadBalancer;
import com.loadbalancer.algorithms.RoundRobinLoadBalancer;
import com.loadbalancer.algorithms.WeightedRoundRobinLoadBalancer;
import com.loadbalancer.config.LoadBalancerConfiguration;
import com.loadbalancer.constant.LoadBalancingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadBalancerService {

    private LoadBalancerConfiguration loadBalancerConfiguration;

    @Autowired
    public LoadBalancerService(LoadBalancerConfiguration loadBalancerConfiguration) {
        this.loadBalancerConfiguration = loadBalancerConfiguration;
    }

    public LoadBalancingAlgorithm getLoadBalancingAlgorithm() {
        return loadBalancerConfiguration.getSelectedAlgorithm();
    }

    public LoadBalancer createLoadBalancingAlgorithmObject() {
        LoadBalancingAlgorithm selectedAlgorithm = getLoadBalancingAlgorithm();
        switch (selectedAlgorithm) {
            case ROUND_ROBIN:
                return new RoundRobinLoadBalancer();
            case WEIGHTED_ROUND_ROBIN:
                return new WeightedRoundRobinLoadBalancer();
            case LEAST_CONNECTIONS:
                return new LeastConnectionsLoadBalancer();
            default:
                throw new IllegalArgumentException("Unknown load balancing algorithm: " + selectedAlgorithm);
        }
    }
}
