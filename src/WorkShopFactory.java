public class WorkShopFactory {

    WorkShop<T> createWorkShop(int capacity, double x, double y, Class<T> type){
        return new WorkShop<T>();
    }

}
