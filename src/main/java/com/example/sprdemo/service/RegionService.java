package com.example.sprdemo.service;

import com.example.sprdemo.mapper.RegionMapper;
import com.example.sprdemo.model.Region;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

  @Resource
  private RegionMapper regionMapper;

  public List<Region> selectRegionsByCityId(int id) {
    Region region = new Region();
    region.setCityId(id);
    return this.selectAllRegion(region);
  }

  public List<Region> selectAllRegion(Region region) {
    return regionMapper.selectAllRegion(region);
  }
}
