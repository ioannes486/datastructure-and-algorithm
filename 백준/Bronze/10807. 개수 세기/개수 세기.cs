namespace CountingNumber
{
    public class Program
    {

        static int N, V;
        static int[] arr;
        static void Main(string[] args)
        {
            using var sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));

            N = int.Parse(sr.ReadLine());
            arr = sr.ReadLine()!.Split().Select(int.Parse).ToArray();       
            V = int.Parse(sr.ReadLine());
            int result = 0;

            for (int i = 0; i < N; i++)
            {
                if (arr[i] == V)
                {
                    result++;
                }
            }
            Console.WriteLine(result);
        }
    }
}
