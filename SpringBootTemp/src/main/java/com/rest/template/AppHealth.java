package com.rest.template;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @author anup yadav
 *
 */
public class AppHealth implements HealthIndicator{

 @Override
 public Health health() {
  int errorCode = check(); // perform some specific health check
  if (errorCode != 0) {
   return Health.down().withDetail("Error Code", errorCode).build();
  }
  return Health.up().build();
 }

 private int check() {
           // Your logic to check health
  return 0;
 }

}