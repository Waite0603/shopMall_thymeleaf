package com.example.sprdemo.service;

import com.example.sprdemo.model.Region;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RegionServiceTest {

  @Resource
  private RegionService regionService;
  @Test
  public void testSelectRegionsByCityId() {
    Region region = new Region();
    region.setCityId(80000);
    List<Region> regions = regionService.selectAllRegion(region);
    System.out.println(regions);
  }
}
