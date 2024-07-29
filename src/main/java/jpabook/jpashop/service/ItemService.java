package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //읽기전용
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    //이 서비스는 상품 리포지토리에 단순히 위임만 하는 클래스임

    @Transactional //우선권을 가짐 -> 읽기전용 적용안됨
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    //조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }
    //단건 조회
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
    /**
     * 영속성 컨텍스트가 자동 변경
     * @param id
     * @param name
     * @param price
     * @param stockQuantity
     */
    @Transactional
    public void updateItem(Long id, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(id);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }
}
