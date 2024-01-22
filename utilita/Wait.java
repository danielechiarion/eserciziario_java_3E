private static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void Wait()
    {
        try{
            Thread.sleep(100);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }   