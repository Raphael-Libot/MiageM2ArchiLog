package plugins;

import application.IAfficheur;
import application.Vache;

public class VacheAfficheur implements IAfficheur{
	@Override
	public String afficher(Vache vache) {
		return  "                                                                                                                                 *##X                        \n"   +   
				"                                                                                                                                 *###*                     \n"   +   
				"                                                                                                                                 ####X                     \n"   +   
				"                                       *#                                                                                 ####X#                     \n"   +   
				"                                       X#X                                                                              #X##X#                     \n"   +   
				"   X                                 *##                                                                              ###X#X                     \n"   +   
				"X#               *XX*      *##X                                                                           X####                        \n"   +   
				"##*      *######XX#   #                                                                           *##X                           \n"   +   
				"###   *#X               #X*   #                                          **                              ##                              \n"   +   
				"#X###X                  X      ##                              ***####                           ##*                           \n"   +   
				"#X      XX                  *###X                        #####X      X#                     *#X*                           \n"   +   
				"   ##X#*                     *      ##*               *#         X            X#                  XXX*                           \n"   +   
				"X#XX#*   X*X      *##XX#X               X#                           X#               #*#                              \n"   +   
				"#####*   #*#*      #X*X*                  #X                              #X         X#   #                              \n"   +   
				"   *   *#*                     ##*                  *##                     X#*   *##*##   XX                              \n"   +   
				"         X#XXX***      #*########*                  X####      ##**   X#                                 \n"   +   
				"   *##*               ***#X   X*         *X*                  *#####   *#XX##*                                 \n"   +   
				"   XX                                 #*                     *X                  #####**#XX*            ##                     \n"   +   
				"   #X   **                        *#            *X                              X###   ##         *X*####                  \n"   +   
				"   #X*##*   X#X            #X   X####                              X#      *#X      ###X      ###            \n"   +   
				"   #X*###   ###X         XX   X####X      *XXXX                     *#XX#                  *#X         \n"   +   
				"   X#   ##X   X##X         XX      X####X   #####                           ##X   *##X      #X         \n"   +   
				"   X#      *         X#            #X   X#####X   #####                                       #XX#*   *#         \n"   +   
				"      ##*                           *#      ######X   #####*                                 *#      X####*      \n"   +   
				"         ###XX***XX##X      ######X   *####*                                 *#            ***         \n"   +   
				"            *X######X**            #####*      ####                                    ##                              \n"   +   
				"                           #*                           ####         *X*                                    ##                                 \n"   +   
				"                           #*                           *XX*                           X*               *#X                                    \n"   +   
				"                           #*                                                               X*X#XXXX#X                                       \n"   +   
				"                           X#                                                            #*      **###                                             \n"   +   
				"                           X#*   *                                             *#               *   X#                                             \n"   +   
				"                           #X#XX*                                    *##               X##X#                                             \n"   +   
				"                           #      X##                     X         ####X*      ##**X                                                \n"   +   
				"                        *#         X#*               X#   X###X*##X   ##                                                         \n"   +   
				"                        #X      X##X            X####X   #XX##X#**                                                         \n"   +   
				"                     #X      X#   *#         *#X               *##*   ##                                                               \n"   +   
				"                     #      *#*   *#         #X                                                                                                      \n"   +   
				"                  *#         #      #X      ##                                                                                                         \n"   +   
				"                  X#   X##      #*      X#                                                                                                         \n"   +   
				"               *#   *#*         #*      X#                                                                                                         \n"   +   
				"         X##X   #*            #X   X#*                                                                                                         \n"   +   
				"         #X         #               #XX#*                                                                                                            \n"   +   
				"      X#   *      XX         ##   #*                                                                                                               \n"   +   
				"      ##X         #*      #X      #*                                                                                                               \n"   +   
				"      *##*X##      X#*      #X                     The   Dutch   Dude                                                \n"   +   
				"         X###X         #X*      #*                                                                                                               \n"   +   
				"                                 #X      X#                                                                                                                  \n"   +   
				"                                 X###X*                                                                                                                  \n"   +   
				"                                       **                                                                                                                        \n";
	}
}