package config;

import member.repository.MemberRepository;
import member.repository.MemoryMemberRepositoryImpl;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import order.DiscountPolicy;
import order.FixDiscountPolicyImpl;
import order.OrderService;
import order.OrderServiceImpl;
import order.PercentDiscountPolicyImpl;

public class AppConfig {

	public MemberRepository getMemberRepository() {
		return MemoryMemberRepositoryImpl.getInstance(); // 싱글톤 패턴
	}
	
	public MemberService getMemberService() {
		return new MemberServiceImpl(getMemberRepository()); //DI
	}
	
	public DiscountPolicy getDiscountPolicy() {
		// 현재 할인 정책 : 고정할인
		// 변경 => 퍼센트 할인으로 바꾸면 된다. 
		return new FixDiscountPolicyImpl(); // 이 부분만 변경하기
		// return new PercentDiscountPolicyImpl(); // 이 부분만 변경하기
	}
	
	public OrderService getOrderService() {
		return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
	}
}
