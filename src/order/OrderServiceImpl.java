package order;

import member.Member;
import member.repository.MemberRepository;

public class OrderServiceImpl implements OrderService {

	// 컴파일러가 기본 생성자를 뽑아줌  -> 초기화 보장X
	private final MemberRepository memberRepository; 
	private final DiscountPolicy discountPolicy;
	
	// 생성자 의존 주입 DI
	public OrderServiceImpl(MemberRepository  memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	// 주문 생성
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId); // 회원 Id 조회
		int discountPrice = discountPolicy.discount(member, itemPrice); // 할인된 금액
		return new Order(memberId, itemName, itemPrice, discountPrice); // 주문 생성(객체 생성 및 생성자 호출)
	}

}
