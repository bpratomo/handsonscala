def flexibleFizzBuzz(f: String => Unit, range: Int) = {
    def rec(counter:Int, f: String =>Unit): Unit = {
        val output = (counter %3, counter %5) match {
            case (0,0) => "FizzBuzz"
            case (0, _) => "Fizz"
            case (_, 0) => "Buzz"
            case (_, _) => counter.toString
        }
        f(output)
        if(counter == range) {}
        else rec(counter+1,f)
    }
    rec(0,f)
    
}