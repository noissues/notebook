package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  // max 代表返回的 Spittle 中 Spittle ID 的最大值
  // count 表明我们要返回多少个 Spittle 对象
  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
