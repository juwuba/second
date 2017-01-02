package com.yc.biz;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;

public interface FavoriteBiz {
	//插入每个网址的具体信息
	public Integer insertInfo(Favorite fovorite);
	//查看每个标签的网址
	public List<Favorite> findFavorite(String id);
	//云图
	public List<Tag> cloud();

}
