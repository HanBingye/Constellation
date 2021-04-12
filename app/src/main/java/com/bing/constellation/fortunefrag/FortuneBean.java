package com.bing.constellation.fortunefrag;

import java.util.List;

public class FortuneBean  {

    /**
     * name : 狮子座
     * date : 2021年
     * year : 2021
     * mima : {"info":"收敛自己的锋芒","text":["随着土星和木星在2020年年底逐渐转入了水瓶座，狮子们的运势也会在2021有着比较明显的回升。你会遇到许多能力突出的贵人，他们可以给你带来不错的好运，也能够让你手头的任务更快更轻松地进行。然而，由于木星处在对宫，你们在贵人的提携下缺少主导权，更多的时候需要好好配合对方的脚步才能够有更加圆满的结果。你们需要在这段时间中努力探索自己的方向，包括自己的职场定位、发展领域、职业形象等等。当你真正找到了适合自己的方向，木星的鲜活活力便会立刻注入你的生命，带你走出迷茫与困境。狮子座今年可佩戴一个星盘保岁吉宏项链作为全年的幸运护身符饰物，银币铸造的船舵星符可提升狮子们的能量指数，寓意今年信心十足、目标明确、勇往直前！"]}
     * career : ["狮子们一向是希望自己在工作中有影响力、有主导权的，但是在2021年，你手头的权力会受到动摇，面对事业你需要做出更多的让步与妥协。但是对你们而言，这并不是一件坏事，因为你的身边会有许多能够提携你，帮助你的贵人，配合对方的脚步能够使你在今年进步颇多。还在读书的狮子们也同样需要培养自己谦虚好学的优点，有不会的问题积极寻求老师、同学的帮助，一定不要置之不理。"]
     * love : ["已经有伴的狮子们需要在2021年格外注重自己的感情问题。相爱容易相处难，你们在生活中有许多需要磨合的地方，不妨收敛一下自己的锋芒，对另一半多些包容。单身的小伙伴们身边围绕着一些桃花，但想要发展出一段关系则需要更多的时间积累才可以。不妨多些耐心，慢慢推进两人之间的感情。"]
     * health : ["狮子们今年的运势不错，但由于木星、海王星聚集在8宫的原因，部分小伙伴会受到酗酒、烟草等诱惑，暴饮暴食等情况也可能会发生。大家千万不要被这些看似美好的事物所迷惑，认真保护好自己的身体是无论如何都要做好的事情。"]
     * finance : ["本年5-7月，木星在你的第八宫运行，这会使你拥有非常不错的偏财运。需要资金流的狮子们能够得到很好的资金支持，而喜欢投资理财的小伙伴们也有机会取得良好的收益。不过，大家一定不要在投资时脑袋一热投入过多的金钱，海王星会使你们理智思考的能力有所下降，而这很容易让你产生不必要的金钱损失。狮子座今年可佩戴一串金狮迎禄手链来提升金钱指数，威猛的狮子是狮子座的守护神兽，寓意添加财气的同时能避免意外的破耗情况，期望今年财运亨通，学业事业皆顺遂。"]
     * luckeyStone : 美国碧玉
     * future :
     * resultcode : 200
     * error_code : 0
     */

    private String name;
    private String date;
    private int year;
    private MimaBean mima;
    private String luckeyStone;
    private String future;
    private String resultcode;
    private int error_code;
    private List<String> career;
    private List<String> love;
    private List<String> health;
    private List<String> finance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MimaBean getMima() {
        return mima;
    }

    public void setMima(MimaBean mima) {
        this.mima = mima;
    }

    public String getLuckeyStone() {
        return luckeyStone;
    }

    public void setLuckeyStone(String luckeyStone) {
        this.luckeyStone = luckeyStone;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<String> getCareer() {
        return career;
    }

    public void setCareer(List<String> career) {
        this.career = career;
    }

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public List<String> getHealth() {
        return health;
    }

    public void setHealth(List<String> health) {
        this.health = health;
    }

    public List<String> getFinance() {
        return finance;
    }

    public void setFinance(List<String> finance) {
        this.finance = finance;
    }

    public static class MimaBean  {
        /**
         * info : 收敛自己的锋芒
         * text : ["随着土星和木星在2020年年底逐渐转入了水瓶座，狮子们的运势也会在2021有着比较明显的回升。你会遇到许多能力突出的贵人，他们可以给你带来不错的好运，也能够让你手头的任务更快更轻松地进行。然而，由于木星处在对宫，你们在贵人的提携下缺少主导权，更多的时候需要好好配合对方的脚步才能够有更加圆满的结果。你们需要在这段时间中努力探索自己的方向，包括自己的职场定位、发展领域、职业形象等等。当你真正找到了适合自己的方向，木星的鲜活活力便会立刻注入你的生命，带你走出迷茫与困境。狮子座今年可佩戴一个星盘保岁吉宏项链作为全年的幸运护身符饰物，银币铸造的船舵星符可提升狮子们的能量指数，寓意今年信心十足、目标明确、勇往直前！"]
         */

        private String info;
        private List<String> text;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public List<String> getText() {
            return text;
        }

        public void setText(List<String> text) {
            this.text = text;
        }
    }
}
