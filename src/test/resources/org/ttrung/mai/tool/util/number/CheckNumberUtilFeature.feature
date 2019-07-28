Feature: Check Number Util Feature

	@tag 1
  Scenario Outline: Check if number is inside threshold range
    Given I have a number <number>
    Given I have a threshold <threshold>
    When I check if <number> is inside range [-<threshold>, Math.abs(<threshold>)] 
    Then it should be <result>

    Examples: 
      | number  | threshold| result |
      | 0		  	| 0		 		| true 		|
      | -2		  | 2		 		| true 		|
      | 1				| 3			 	| true 		|
      | 4  			| 3			 	| false		|
      