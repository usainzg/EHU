
#include <sys/time.h>
#include <stdio.h>
#include <math.h>
#include <stdlib.h>

double calculate (int x, int y)
{
        int i;
        double value;

        for (i=0;i<1000000;i++) value=pow((double)x,(double)y);
        return (value);
}

main(int argc, char *argv[])
{
  struct timeval tstart,tend;
  double texe, res;

  if (argc!=3)
  {
        #ifdef ENGLISH
                printf ("\nERROR IN PARAMETERS. Program %s int int\n",argv[0]);
        #else
                printf ("\nPARAMETROAZ EZ DIRA ZUZENAK. Programa %s int int\n",argv[0]);
        #endif
        exit(-1);
  }

  gettimeofday(&tstart,0);

  res=calculate(atoi(argv[1]),atoi(argv[2]));

  gettimeofday(&tend,0);
  texe=(tend.tv_sec-tstart.tv_sec)+(tend.tv_usec-tstart.tv_usec)/1e6;
  printf("Execution time %f seconds -- Result: %.1f\n",texe,res);
}
