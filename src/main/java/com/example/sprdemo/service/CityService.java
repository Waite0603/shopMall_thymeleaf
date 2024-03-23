package com.example.sprdemo.service;
import com.example.sprdemo.model.City;
import com.example.sprdemo.model.Region;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.sprdemo.mapper.CityMapper;
import java.util.List;

@Service
public class CityService {

  @Resource
  private CityMapper cityMapper;

  @Resource RegionService regionService;


  public List<City> selectCityByProvinceId(int id) {
    City city = new City();
    city.setProvId(id);
    List<City> cities = this.selectAllCity(city);
    for( City c:cities) {
      List<Region> regcions = regionService.selectRegionsByCityId(c.getId());
      c.setRegions(regcions);
    }
    return cities;
  }

  public List<City> selectAllCity(City city) {
    return cityMapper.selectAllCity(city);
  }
}
