# Copyright (c) 2008-2009 by David Golden. All rights reserved.
# Licensed under Apache License, Version 2.0 (the "License").
# You may not use this file except in compliance with the License.
# A copy of the License was distributed with this file or you may obtain a 
# copy of the License from http://www.apache.org/licenses/LICENSE-2.0

package Devel::Autoflush;
$Devel::Autoflush::VERSION = '0.05';

my $kwalitee_nocritic = << 'END';
# can't use strict as older stricts load Carp and we can't allow side effects
use strict;  
END

my $old = select STDOUT; $|++;
select STDERR; $|++;
select $old;

1;

__END__

#--------------------------------------------------------------------------#
# pod documentation 
#--------------------------------------------------------------------------#

=begin wikidoc

= NAME

Devel::Autoflush - Set autoflush from the command line

= VERSION

This documentation describes version %%VERSION%%.

= SYNOPSIS

 perl -MDevel::Autoflush Makefile.PL

= DESCRIPTION

This module is a hack to set autoflush for STDOUT and STDERR from the command
line or from {PERL5OPT} for code that needs it but doesn't have it.

This often happens when prompting:

  # guess.pl
  print "Guess a number: ";
  my $n = <STDIN>;

As long as the output is going to a terminal, the prompt is flushed when STDIN
is read.  However, if the output is being piped, the print statement will 
not automatically be flushed, no prompt will be seen and the program will
silently appear to hang while waiting for input.  This might happen with 'tee':

  $ perl guess.pl | tee capture.out

Use Devel::Autoflush to work around this:

  $ perl -MDevel::Autoflush guess.pl | tee capture.out

Or set it in {PERL5OPT}:

  $ export PERL5OPT=-MDevel::Autoflush
  $ perl guess.pl | tee capture.out

= BUGS

Please report any bugs or feature using the CPAN Request Tracker.  
Bugs can be submitted through the web interface at 
[http://rt.cpan.org/Dist/Display.html?Queue=Devel-Autoflush]

When submitting a bug or request, please include a test-file or a patch to an
existing test-file that illustrates the bug or desired feature.

= SEE ALSO

* [CPANPLUS::Internals::Utils::Autoflush] -- same idea but STDOUT only and 
only available as part of the full CPANPLUS distribution

= AUTHOR

David A. Golden (DAGOLDEN)

= COPYRIGHT AND LICENSE

Copyright (c) 2008-2009 by David A. Golden

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at 
[http://www.apache.org/licenses/LICENSE-2.0]

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

=end wikidoc

=cut
