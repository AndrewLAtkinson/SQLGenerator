package com.werdna.sql;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class SQLGenerator {
public static void main ( String[] args ) throws IOException {

  int i = 0;

  BufferedWriter sqlfile;
  FileWriter     file = new FileWriter ( "sqlinsert.sql" );

  sqlfile = new BufferedWriter ( file );
  GregorianCalendar[] jDate = new GregorianCalendar[ 2 ];
  do jDate[ i++ ] = new GregorianCalendar ( ); while ( i < 2 );

  Date realDate = new Date ( jDate[ 0 ].getTime ( ).getTime ( ) );
  Date simDate  = new Date ( jDate[ 1 ].getTime ( ).getTime ( ) );

  sqlfile.write ( "( " );

  for ( i = 1; i <= 8 ; i++ ) {
    for ( int j = 1 ; j <= 31 ; j++ ) {
      sqlfile.write ( "( " );
      jDate[ 0 ].set ( 2017, i, j );
      realDate.setTime ( jDate[ 0 ].getTimeInMillis ( ) );
      Calendar.getInstance ( );
      Calendar.getInstance ( );
      if ( realDate.getDay ( ) > ( Calendar.SUNDAY ) && realDate.getDay ( ) < ( Calendar.SUNDAY ) )
        sqlfile.write ( realDate.toString ( ) );
      jDate[ 1 ].set ( 2017, i + 3, j );
      simDate.setTime ( jDate[ 1 ].getTimeInMillis ( ) );
      if ( jDate[ 1 ].after ( Calendar.MONDAY ) && jDate[ 1 ].before ( Calendar.SATURDAY ) ) {
        sqlfile.write ( "," + simDate.toString ( ) + " ), " );
      }
    }
  }
  sqlfile.write ( ");" );
  sqlfile.close ( );
}
}



	
