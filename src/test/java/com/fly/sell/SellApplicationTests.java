package com.fly.sell;

import com.fly.sell.dao.*;
import com.fly.sell.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

	@Autowired
	SellerMasterMapper sellerMasterMapper;

	@Autowired
	SellerInfoMapper sellerInfoMapper;

	@Autowired
	SellerSupportsMapper sellerSupportsMapper;

	@Autowired
	ProductCategoryMapper productCategoryMapper;

	@Autowired
	ProductInfoMapper productInfoMapper;

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Test
	public void contextLoads() {
		SellerMaster sellerMaster = sellerMasterMapper.selectByPrimaryKey(1);
		System.out.println(sellerMaster);
	}

	@Test
	public void saveSellerInfo() {
		SellerInfo sellerInfo1 = new SellerInfo();
		sellerInfo1.setSellerId(1);
		sellerInfo1.setInfo("该商家支持发票,请下单写好发票抬头");
		sellerInfoMapper.insertSelective(sellerInfo1);

		SellerInfo sellerInfo2 = new SellerInfo();
		sellerInfo2.setSellerId(1);
		sellerInfo2.setInfo("品类:其他菜系,包子粥店");
		sellerInfoMapper.insertSelective(sellerInfo2);

		SellerInfo sellerInfo3 = new SellerInfo();
		sellerInfo3.setSellerId(1);
		sellerInfo3.setInfo("北京市昌平区回龙观西大街龙观置业大厦底商B座102单元1340");
		sellerInfoMapper.insertSelective(sellerInfo3);

		SellerInfo sellerInfo4 = new SellerInfo();
		sellerInfo4.setSellerId(1);
		sellerInfo4.setInfo("营业时间:10:00-20:30");
		sellerInfoMapper.insertSelective(sellerInfo4);

		SellerInfo sellerInfo5 = new SellerInfo();
		sellerInfo5.setSellerId(1);
		sellerInfo5.setInfo("欢迎广大客户品尝");
		sellerInfoMapper.insertSelective(sellerInfo5);


	}

	@Test
	public void saveSellerSupport() {
		SellerSupports sellerSupports1 = new SellerSupports();
		sellerSupports1.setSellId(1);
		sellerSupports1.setType(0);
		sellerSupports1.setDescription("在线支付满28减5");
		sellerSupportsMapper.insertSelective(sellerSupports1);

		SellerSupports sellerSupports2 = new SellerSupports();
		sellerSupports2.setSellId(1);
		sellerSupports2.setType(1);
		sellerSupports2.setDescription("VC无限橙果汁全场8折");
		sellerSupportsMapper.insertSelective(sellerSupports2);

		SellerSupports sellerSupports3 = new SellerSupports();
		sellerSupports3.setSellId(1);
		sellerSupports3.setType(2);
		sellerSupports3.setDescription("单人精彩套餐");
		sellerSupportsMapper.insertSelective(sellerSupports3);

		SellerSupports sellerSupports4 = new SellerSupports();
		sellerSupports4.setSellId(1);
		sellerSupports4.setType(3);
		sellerSupports4.setDescription("该商家支持发票,请下单写好发票抬头");
		sellerSupportsMapper.insertSelective(sellerSupports4);

		SellerSupports sellerSupports5 = new SellerSupports();
		sellerSupports5.setSellId(1);
		sellerSupports5.setType(3);
		sellerSupports5.setDescription("已加入“外卖保”计划,食品安全保障");
		sellerSupportsMapper.insertSelective(sellerSupports5);


	}

	@Test
	public void saveProductInfo() {
//		ProductInfo productInfo1 = new ProductInfo();
//		productInfo1.setCategoryId(1);
//		productInfo1.setName("招牌猪肉白菜锅贴/10个");
//		productInfo1.setPrice(new BigDecimal(15));
////		productInfo1.setOldPrice(new BigDecimal(20));
//		productInfo1.setDescription("超好吃的锅贴~");
//		productInfo1.setSellCount(101);
//		productInfo1.setRating(77.0);
//		productInfo1.setInfo("多的不说，下单就对了");
//		productInfo1.setIcon("http://fuss10.elemecdn.com/7/72/9a580c1462ca1e4d3c07e112bc035jpeg.jpeg?imageView2/1/w/114/h/114");
//		productInfo1.setImage("http://fuss10.elemecdn.com/7/72/9a580c1462ca1e4d3c07e112bc035jpeg.jpeg?imageView2/1/w/750/h/750");
//		productInfoMapper.insertSelective(productInfo1);

		ProductInfo productInfo2 = new ProductInfo();
		productInfo2.setCategoryId(1);
		productInfo2.setName("皮蛋瘦肉粥");
		productInfo2.setPrice(new BigDecimal(12));
//		productInfo2.setOldPrice(new BigDecimal(20));
		productInfo2.setDescription("好喝的粥~");
		productInfo2.setSellCount(99);
		productInfo2.setRating(100.0);
		productInfo2.setInfo("一碗皮蛋瘦肉粥，总是我到粥店时的不二之选。香浓软滑，饱腹暖心，皮蛋的Q弹与瘦肉的滑嫩伴着粥香溢于满口，让人喝这样的一碗粥也觉得心满意足");
		productInfo2.setIcon("http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo2.setImage("http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo2);

		ProductInfo productInfo3 = new ProductInfo();
		productInfo3.setCategoryId(2);
		productInfo3.setName("红枣山药粥套餐");
		productInfo3.setPrice(new BigDecimal(30));
		productInfo3.setOldPrice(new BigDecimal(36));
		productInfo3.setDescription("红枣山药糙米粥,素材包,爽口莴笋丝,四川泡菜或八宝酱菜,配菜可备注");
		productInfo3.setSellCount(17);
		productInfo3.setRating(99.0);
		productInfo3.setInfo("");
		productInfo3.setIcon("http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo3.setImage("http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo3);

		ProductInfo productInfo4 = new ProductInfo();
		productInfo4.setCategoryId(3);
		productInfo4.setName("葱花饼");
		productInfo4.setPrice(new BigDecimal(10));
		productInfo4.setOldPrice(new BigDecimal(12));
		productInfo4.setDescription("");
		productInfo4.setSellCount(56);
		productInfo4.setRating(86.0);
		productInfo4.setInfo("");
		productInfo4.setIcon("http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo4.setImage("http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo4);

		ProductInfo productInfo5 = new ProductInfo();
		productInfo5.setCategoryId(3);
		productInfo5.setName("牛肉馅饼");
		productInfo5.setPrice(new BigDecimal(14));
		productInfo5.setOldPrice(new BigDecimal(16));
		productInfo5.setDescription("");
		productInfo5.setSellCount(78);
		productInfo5.setRating(98.0);
		productInfo5.setInfo("");
		productInfo5.setIcon("http://fuss10.elemecdn.com/d/b9/bcab0e8ad97758e65ae5a62b2664ejpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo5.setImage("http://fuss10.elemecdn.com/d/b9/bcab0e8ad97758e65ae5a62b2664ejpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo5);

		ProductInfo productInfo6 = new ProductInfo();
		productInfo6.setCategoryId(4);
		productInfo6.setName("八宝酱菜");
		productInfo6.setPrice(new BigDecimal(4));
//		productInfo6.setOldPrice(new BigDecimal(16));
		productInfo6.setDescription("");
		productInfo6.setSellCount(84);
		productInfo6.setRating(97.0);
		productInfo6.setInfo("");
		productInfo6.setIcon("http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo6.setImage("http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo6);

		ProductInfo productInfo7 = new ProductInfo();
		productInfo7.setCategoryId(4);
		productInfo7.setName("拍黄瓜");
		productInfo7.setPrice(new BigDecimal(9));
//		productInfo7.setOldPrice(new BigDecimal(16));
		productInfo7.setDescription("");
		productInfo7.setSellCount(36);
		productInfo7.setRating(100.0);
		productInfo7.setInfo("");
		productInfo7.setIcon("http://fuss10.elemecdn.com/6/54/f654985b4e185f06eb07f8fa2b2e8jpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo7.setImage("http://fuss10.elemecdn.com/6/54/f654985b4e185f06eb07f8fa2b2e8jpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo7);

		ProductInfo productInfo8 = new ProductInfo();
		productInfo8.setCategoryId(5);
		productInfo8.setName("VC橙汁");
		productInfo8.setPrice(new BigDecimal(8));
		productInfo8.setOldPrice(new BigDecimal(10));
		productInfo8.setDescription("");
		productInfo8.setSellCount(21);
		productInfo8.setRating(100.0);
		productInfo8.setInfo("");
		productInfo8.setIcon("http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo8.setImage("http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo8);

		ProductInfo productInfo9 = new ProductInfo();
		productInfo9.setCategoryId(5);
		productInfo9.setName("加多宝");
		productInfo9.setPrice(new BigDecimal(6));
//		productInfo9.setOldPrice(new BigDecimal(16));
		productInfo9.setDescription("");
		productInfo9.setSellCount(18);
		productInfo9.setRating(100.0);
		productInfo9.setInfo("");
		productInfo9.setIcon("http://fuss10.elemecdn.com/b/9f/5e6c99c593cf65229225c5661bcdejpeg.jpeg?imageView2/1/w/114/h/114");
		productInfo9.setImage("http://fuss10.elemecdn.com/b/9f/5e6c99c593cf65229225c5661bcdejpeg.jpeg?imageView2/1/w/750/h/750");
		productInfoMapper.insertSelective(productInfo9);



	}

	@Test
	public void saveProductCategory() {
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setName("热销榜");
		productCategory1.setType(-1);
		productCategoryMapper.insertSelective(productCategory1);

		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setName("特价套餐");
		productCategory2.setType(2);
		productCategoryMapper.insertSelective(productCategory2);

		ProductCategory productCategory3 = new ProductCategory();
		productCategory3.setName("限时折扣优惠");
		productCategory3.setType(1);
		productCategoryMapper.insertSelective(productCategory3);

		ProductCategory productCategory4 = new ProductCategory();
		productCategory4.setName("店家推荐");
		productCategory4.setType(-1);
		productCategoryMapper.insertSelective(productCategory4);

		ProductCategory productCategory5 = new ProductCategory();
		productCategory5.setName("果汁饮料");
		productCategory5.setType(-1);
		productCategoryMapper.insertSelective(productCategory5);


	}

	@Test
	public void testRedis(){
		redisTemplate.opsForValue().set("hhh", "www");
		System.out.println(redisTemplate.opsForValue().get("hhh"));
		redisTemplate.opsForValue().setIfAbsent("hhh", "111", 1000, TimeUnit.MILLISECONDS);
		System.out.println(redisTemplate.opsForValue().get("hhh"));
		redisTemplate.opsForValue().setIfPresent("hhh", "111", 1000, TimeUnit.MILLISECONDS);
		System.out.println(redisTemplate.opsForValue().get("hhh"));
	}


}
