@tag
Feature: Check Number Util Feature

	@tagNumberInThreshold
  Scenario Outline: Check if <number> is inside threshold absolute (-<threshold>, Math.abs(<threshold>))
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
      
      
  @tagNumberIsNullZero    
  Scenario Outline: Check if <number> is null or zero
    Given I have a number <number>
    When I check if <number> is null or zero 
    Then it should be <result>

    Examples: 
      | number  | result 	|
      | 0		  	| true 		|
      | null	  | true 		|
      | 4	 		 	| false 	|
      
  @tagNumberNotNullNotZero    
  Scenario Outline: Check if <number> is not null and and not zero
    Given I have a number <number>
    When I check if <number> is not null and not zero 
    Then it should be <result>

    Examples: 
      | number  | result 	|
      | 0		  	| false 	|
      | null	  | false 	|
      | 4	 		 	| true 		|
