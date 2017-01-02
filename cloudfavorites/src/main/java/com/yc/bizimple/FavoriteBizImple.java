package com.yc.bizimple;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.util.Dao;

public class FavoriteBizImple implements FavoriteBiz {

	//插入每个网站的具体信息
	@Override
	public Integer insertInfo(Favorite fovorite) {
		SqlSession session=null;
		try {
			session = Dao.getSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer t=0;
		try {
			String [] f_tags=null;
			if(fovorite.getF_tags().contains(",")){
				f_tags=fovorite.getF_tags().split(",");
			}else if(fovorite.getF_tags().contains("，")){
				f_tags=fovorite.getF_tags().split("，");
			}
			List<Tag> list=session.selectList("com.yc.mapper.TagMapper.tagAll");
			boolean flag=true;
			if(f_tags!=null){
				for(int i=0;i<f_tags.length;i++){
					for(Tag tag:list){
						if(tag.getT_name().equals(f_tags[i])){
							flag=false;
							break;
						}
					}
					if(flag){
						Tag tag1=new Tag();
						tag1.setT_name(f_tags[i]);
						t=session.insert("com.yc.mapper.TagMapper.Insertinfo", tag1);
						session.commit();
					}else{
						Tag tag2=new Tag();
						tag2.setT_name(f_tags[i]);
						Tag tag3=new Tag();
						tag3=session.selectOne("com.yc.mapper.TagMapper.tagCount", tag2);
						Integer num=tag3.getT_count();
						num++;
						tag3.setT_count(num);
						tag3.setT_name(f_tags[i]);
						session.update("com.yc.mapper.TagMapper.tagCountUpdate", tag3);
						session.commit();
					}
					flag=true;
				}
			}
			t=session.insert("com.yc.mapper.FavoriteMapper.Insertinfo", fovorite);
			session.commit();
		} finally {
			session.close();
		}
		return t;
	}

	//查看每个标签的网址信息
	@Override
	public List<Favorite> findFavorite(String id) {
		SqlSession session=null;
		try {
			session = Dao.getSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer t=0;
		Tag tag=new Tag();
		if(Integer.parseInt(id)>=0){
			tag.setT_id(Integer.parseInt(id));
			Tag tag1=new Tag();
			tag1=session.selectOne("com.yc.mapper.TagMapper.tag", tag);
			tag.setT_name("%"+tag1.getT_name()+"%");
		}else if(Integer.parseInt(id)==-2){
			List<Favorite> list=session.selectList("com.yc.mapper.FavoriteMapper.findinfoNULL");
			return list;
		}
		List<Favorite> list=null;
		try {
			list=session.selectList("com.yc.mapper.FavoriteMapper.findinfo",tag);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}
	//云图
	@Override
	public List<Tag> cloud() {
		SqlSession session=null;
		List<Tag> list=null;
		try {
			session = Dao.getSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer t=0;
		try {
			list=session.selectList("com.yc.mapper.TagMapper.tagAll");
		} finally {
			session.close();
		}
		return list;
	}

}
